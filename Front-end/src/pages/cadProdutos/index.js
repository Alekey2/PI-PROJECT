
import { useEffect, useState } from 'react';
import axios from 'axios'
import './index.scss';
import Logo from "../../assets/images/logo.png"




export default function CadProdutos() {


    const [codprod, setCodProd] = useState('')
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [preco, setPreco] = useState('');
    const [custo, setCusto] = useState('');
    const [listaproduto, setListaProduto] = useState([]);


    async function ListarProdutos() {
        try {
            let r = await axios.get('http://localhost:1010/stock');
            let produtos = r.data;
            setListaProduto(produtos);
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
        }
    }

    async function salvarProdutos() {
        
    
       
        if (!nome || !descricao || !preco || !custo) {
            alert('Por favor, preencha todos os campos.');
            return; 
        }
    
      
        let body = {
            nome: nome,
            descricao: descricao,
            preco: Number(preco),
            custo: Number(custo),
        };
    
       
        try {
            await axios.post('http://localhost:1010/stock', body);
            alert('Produto cadastrado!');
            window.location.reload();
            ListarProdutos();
        } catch (error) {
            console.error('Erro ao cadastrar o produto:', error);
        }
    }
    


    async function alterarProduto(produtoId, novosDados) {
        try {
            if (!produtoId) {
                alert('ID do produto não foi fornecido');
                return;
            }

            let r = await axios.put(`http://localhost:1010/stock/${produtoId}`, novosDados);

            if (r.status === 200) {
                alert('Cadastro alterado com sucesso.');
            } else {
                alert('Falha ao alterar o cadastro.');
            }
        } catch (error) {
            alert('Ocorreu um erro ao tentar alterar o cadastro:', error);
        }
        ListarProdutos();
    }

    async function excluirProduto(produtoId) {
        try {
            const response = await axios.delete(`http://localhost:1010/stock/${produtoId}`);

            if (response.status === 202) {
                alert('Produto excluído com sucesso.');
            } 
        } catch (error) {
            alert('Ocorreu um erro ao tentar excluir o produto:', error);
        }
        ListarProdutos();
    }


    return (

        <section className="container">

            <section className="sec1">
                <a href="/">
                <img src={Logo} alt="logo da loja toca raul" />
                </a>

                <h1>Cadastro de Produtos</h1>

                <div className="divInput">
                    <label htmlFor="nome">Digite o ID para Alterar ou Deletar </label>
                    <input type="number" id="id" name="id" required value={codprod} onChange={e => setCodProd(e.target.value)} />

                    <label htmlFor="nome">Nome do Produto:</label>
                    <input type="text" id="nome" name="nome" required value={nome} onChange={e => setNome(e.target.value)} />

                    <label htmlFor="descrição">Descrição do Produto:</label>
                    <input type="text" id="descrição" name="descrição" required value={descricao} onChange={e => setDescricao(e.target.value)} />

                    <label htmlFor="Preco"> Preço:</label>
                    <input type="text" id="preco" name="preco" required value={preco} onChange={e => setPreco(e.target.value)} />

                    <label htmlFor="Custo">Custo:</label>
                    <input type="number" id="custo" name="custo" required value={custo} onChange={e => setCusto(e.target.value)} />


                </div>

                <div className="divbotao">
                    <button onClick={salvarProdutos}> Cadastrar </button>
                    <button onClick={() => alterarProduto(codprod, {
                        nome: nome,
                        descricao: descricao,
                        preco: preco,
                        custo: custo,
                    })}> Alterar </button>

                </div>
            </section>


            <section className="sec2">
                <div className="tituloSec2">
                    <h1>Listagem de Produtos</h1>
                </div>

                <div className="cabecalho-sec2">
                    <p>Código</p>
                    <p>Nome</p>
                    <p>Descrição</p>
                    <p>Custo</p>
                    <p>Valor R$</p>
                </div>



                <hr />

                <div className="insereProduto">
                    {listaproduto.map(item =>
                        <div key={item.id} className='produto'>
                            <p className="codigo">{item.id}</p>
                            <p className="text1">{item.nome}</p>
                            <p className="descricao">{item.descricao}</p>
                            <p className="quantidade">R${item.custo}</p>
                            <p className="valor">R$ {item.preco}</p>

                        </div>

                    )}

                </div>

                <div className="botoes">

                    <div className="divbotao">
                        <button onClick={() => ListarProdutos()}> Atualizar </button>
                        <button onClick={() => excluirProduto(codprod)}> Excluir </button>
                    </div>

                </div>
            </section>
        </section>

    );

}
