import { useState } from "react";
import Botao from "../Botao";
import CampoData from "../CampoData";
import CampoTexto from "../CampoTexto/CampoTexto";
import ListaSuspensa from "../ListaSuspensa";
import "./Formulario.css";
import Modal from "../Modal/Index";

const Formulario = (props) => {
  const [nome, setNome] = useState("");
  const [sobrenome, setSobrenome] = useState("");
  const [dataNasc, setDataNasc] = useState("");
  const [imagem, setImagem] = useState("");
  const [posicao, setPosicao] = useState("Goleiro");
  const [time, setTime] = useState("Botafogo");

  const [nomeDoTime, setNomeDoTime] = useState("")
  const [corPrimaria, setCorPrimaria] = useState("")
  const [corSecundaria, setCorSecundaria] = useState("")

  const [isModalOpen, setModalOpen] = useState(false);

  const openModal = () => setModalOpen(true);
  const closeModal = () => setModalOpen(false);

  const aoSalvar = (evento) => {
    evento.preventDefault();
    props.aoJogadorCadastrado({
      nome,
      sobrenome,
      dataNasc,
      imagem,
      posicao,
      time,
    });
    setNome("");
    setSobrenome("");
    setDataNasc("");
    setImagem("");
    setPosicao("");
    setTime("");
  };

  const aoSalvarCadastreTime = (evento) => {
    evento.preventDefault();
    props.aoTimeCadastrado({
      nomeDoTime,
      corPrimaria,
      corSecundaria
    });
    setNomeDoTime("");
    setCorPrimaria("");
    setCorSecundaria("");

  };

  return (
    <section className="formulario">
      <form onSubmit={aoSalvar}>
        <div className="border-b border-gray-900/10 pb-12">
          <h2 className="text-base/7 font-semibold text-gray-900">
            Preencha os dados para criar o card do jogador.
          </h2>

          <hr className="border-gray-500" />
          <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
            <div div className="sm:col-span-3">
              <CampoTexto
                obrigatorio={true}
                label="Nome"
                placeholder="Digite o nome"
                valor={nome}
                aoAlterado={(valor) => setNome(valor)}
              />
            </div>
            <div div className="sm:col-span-3">
              <CampoTexto
                obrigatorio={true}
                label="Sobrenome"
                placeholder="Digite o sobrenome"
                valor={sobrenome}
                aoAlterado={(valor) => setSobrenome(valor)}
              />
            </div>
          </div>
          <div className="sm:col-span-6">
            <div className="mt-2">
              <CampoData
                obrigatorio={true}
                label="Data nascimento"
                valor={dataNasc}
                aoAlterado={(valor) => setDataNasc(valor)}
              />
            </div>
          </div>
          <div className="sm:col-span-6">
            <div className="mt-2">
              <CampoTexto
                label="Imagem"
                placeholder="Digite o endereço da imagem"
                valor={imagem}
                aoAlterado={(valor) => setImagem(valor)}
              />
            </div>
          </div>
          <div className="sm:col-span-3">
            <div className="mt-2">
              <ListaSuspensa
                obrigatorio={true}
                label="Posição no campo"
                itens={props.posicoesTime}
                valor={posicao}
                aoAlterado={(valor) => setPosicao(valor)}
              />
            </div>
          </div>
          <div className="sm:col-span-3">
            <div className="mt-2">
              <ListaSuspensa
                obrigatorio={true}
                label="Times do brasileirão 2024"
                itens={props.times}
                valor={time}
                aoAlterado={(valor) => setTime(valor)}
              />
            </div>
            
          </div>
          <br />
          <Botao texto="Criar Card">Criar Card </Botao>
        </div>
      </form>
    </section>
  );
};

export default Formulario;
