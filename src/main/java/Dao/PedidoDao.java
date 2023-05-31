package Dao;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import Vo.RelatorioDeVendasVo;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import model.Pedido;
import model.Produto;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}


    public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}


	public  BigDecimal ValorTotalVendas() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public BigDecimal MaiorValorDaColuna() {
		String jpql = "SELECT MAX(p.valorTotal) FROM Pedido p"; // query pedindo a media da tabela de pedido da coluna valorTotal
		return em.createQuery(jpql, BigDecimal.class).getSingleResult(); // getSingleResult -> Esperando apenas um resultado
	}

	public List<RelatorioDeVendasVo> relatorioDeVendas() { //Object -> significa que e um array de objetos onde retornara 3 tipos de dados
		String jpqlRelatorio = "SELECT new Vo.RelatorioDeVendasVo(produto.nome,SUM(item.quantidade),MAX(pedido.data)) FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto GROUP BY produto.nome ORDER BY item.quantidade DESC";
		return em.createQuery(jpqlRelatorio,RelatorioDeVendasVo.class).getResultList();
	}

	public Pedido buscarPedidoComCliente(Long id) {
		//Join Fetch so ira fazer a consulta quando for necessario e estiuver naquela tela
		String jpqlBuscarPedido = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";
		return em.createQuery(jpqlBuscarPedido,Pedido.class).setParameter("id", id)
				.getSingleResult();
	}

	//Consulta dinamica vamos se dizer que um parametro opcional
	public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
		String jpql = "SELECT p FROM Produto p WHERE  1=1 ";

		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nome = :nome ";
		}
		if (preco != null) {
			jpql = " AND p.preco = :preco ";
		}
		if (dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro ";
		}

		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);

		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (preco != null) {
			query.setParameter("preco", preco);
		}
		if (dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}

		return query.getResultList();
	}

	//Criteria API outra maneira de fazer a mesma consulta acima so que otimizado
	public List<Produto> buscaPorParametrosComCriteria(String nome,BigDecimal preco,LocalDate dataCadastro) {
		CriteriaBuilder builder = em.getCriteriaBuilder(); // pede para retornar um objetivo do tipo builder
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class); // da onde sera disparado a query ?

		Predicate filtros = builder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			//Função and -> E
			//Função equal -> igual
			//Função get -> pegar um valor ou parametro
			filtros = builder.and(filtros, builder.equal(from.get("nome"),nome));
		}
		if (preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"),preco));
		}
		if (dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"),dataCadastro));
		}
		query.where(filtros);

		return em.createQuery(query).getResultList();
	}

	@Override
	public String toString() {
		return "PedidoDao{" +
				"em=" + em +
				'}';
	}
}
