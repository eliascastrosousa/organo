import { useEffect, useState } from "react";
import Banner from "./componentes/Banner";
import Formulario from "./componentes/Formulario";
import Rodape from "./componentes/Rodape";
import Time from "./componentes/Time";
import api from "./services/api";

function App() {
  const [colaboradores, setColaboradores] = useState([]);
  const [times, setTimes] = useState([]);
  const [error, setError] = useState(null);

  const fetchTimes = async () => {
    try {
      const response = await api.get("times");
      setTimes(response.data);
    } catch (error) {
      console.error("Erro ao buscar times:", error);
    }
  };
  const fetchColaboradores = async () => {
    try {
      const response = await api.get("colaboradores");
      setColaboradores(response.data);
    } catch (error) {
      setError(error)
      console.error("Erro ao buscar colaboradores:", error);
    }
  };

  useEffect(() => {
    fetchTimes();
    fetchColaboradores();    
  }, []); 

  if (error) return <p>{error}</p>;

  function deletarColaborador(id) {
    setColaboradores(
      colaboradores.filter((colaborador) => colaborador.id !== id)
    );
  }

  function cadastrarTime({ nome, cor }) {
    setTimes([...times, { nome, cor }]);
  }

  function resolverFavorito(id) {
    setColaboradores(
      colaboradores.map((colaborador) => {
        if (colaborador.id === id) colaborador.favorito = !colaborador.favorito;
        return colaborador;
      })
    );
  }

  function mudarCor(cor, id) {
    setTimes(
      times.map((time) => {
        if (time.id === id) {
          time.cor = cor;
        }
        return time;
      })
    );
  }


  return (
    <div>
      <Banner />
      <Formulario
        times={times.map((time) => time.nome)}
        aoCadastrar={
          (colaborador) => setColaboradores([...colaboradores, colaborador])
        }
        aoCriarTime={cadastrarTime}

      />
      <section className="times">
        <h1 style={{ textAlign: "center" }}>Minha organização</h1>
        {times.map((time, indice) => (
          <Time
            key={indice}
            time={time}
            mudarCor={mudarCor}
            colaboradores={colaboradores.filter(
              (colaborador) => colaborador.nomeTime === time.nome
            )}
            aoDeletar={deletarColaborador}
            aoFavoritar={resolverFavorito}
          />
        ))}
      </section>
      <Rodape />
    </div>
  );
}

export default App;
