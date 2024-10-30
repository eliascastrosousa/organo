import { useState } from 'react';
import Botao from '../Botao';
import CampoData from '../CampoData';
import CampoTexto from '../CampoTexto/CampoTexto'
import ListaSuspensa from '../ListaSuspensa';
import './Formulario.css'


const Formulario = (props) => {

    const [nome, setNome] = useState('')
    const [dataNasc, setDataNasc] = useState('')
    const [imagem, setImagem] = useState('')
    const [posicao, setPosicao] = useState('Goleiro')
    const [time, setTime] = useState('Botafogo')


    const aoSalvar = (evento) =>{
        evento.preventDefault()
        props.aoJogadorCadastrado({
            nome,
            dataNasc, 
            imagem, 
            posicao, 
            time
        })
        setNome('')
        setDataNasc('')
        setImagem('')
        setPosicao('')
        setTime('')
        
    }

    return (
        <section className="formulario">
            <form onSubmit={aoSalvar}>
                <h2>Preencha os dados para criar o card do Jogador</h2>
                
                <CampoTexto 
                    obrigatorio={true} 
                    label="Nome" 
                    placeholder="Digite o nome"
                    valor={nome} 
                    aoAlterado = {valor => setNome(valor)}
                />
            
                <CampoData 
                    obrigatorio={true} 
                    label="Data nascimento" 
                    valor={dataNasc} 
                    aoAlterado = {valor => setDataNasc(valor)}
                />
                
                <CampoTexto
                    label="Imagem" 
                    placeholder="Digite o endereço da imagem" 
                    valor = {imagem}
                    aoAlterado = {valor => setImagem(valor)}
                />
                
                <ListaSuspensa 
                    obrigatorio={true} 
                    label="Posição campo" 
                    itens={props.posicoesTime}
                    valor = {posicao}
                    aoAlterado = {valor => setPosicao(valor)}
                />

                <ListaSuspensa 
                    obrigatorio={true} 
                    label="Times do brasileirão 2024" 
                    itens={props.times}
                    valor = {time}
                    aoAlterado = {valor => setTime(valor)}
                />

                <Botao texto="Criar Card">Criar Card </Botao>
            </form>
        </section>
    )
}

export default Formulario;