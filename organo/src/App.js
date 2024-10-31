import { useState } from 'react';
import Banner from './componentes/Banner';
import Formulario from './componentes/Formulario';
import Time from './componentes/Time';
import Rodape from './componentes/Rodape';
import Navbar from './componentes/Navbar/Index';

function App() {

  const times = [
    {
      nome: 'Botafogo',
      corPrimaria:'#212529',
      corSecundaria:'#f8f9fa'
    },
    {
      nome: 'Palmeiras',
      corPrimaria:'#008000',
      corSecundaria:'#9ef01a'
    },
    {
      nome: 'São Paulo',
      corPrimaria:'#f21b3f',
      corSecundaria:'#01110a'
    },{
      nome: 'Cruzeiro',
      corPrimaria:'#0077b6',
      corSecundaria:'#ffffff'
    }
  ];

  const posicoesTime = [
    'Goleiro',
    'Lateral direito',
    'Lateral esquerdo',
    'Zagueiro',
    'Zagueiro central',
    'Volante',
    'Meio-campista direito (ala)',
    'Meio-campista centro (ala)',
    'Meio-campista (meia-armador)',
    'Meio-campista ofensivo (meia-atacante)',
    'Centroavante'
  ]

  const [jogadores, setJogadores] = useState([])

  const aoNovoJogadorAdicionado = (jogador) => {
    debugger 
    setJogadores([...jogadores, jogador])
  }

  return (
    <div className="App">
      <Navbar/>
      <Banner/>
      <Formulario posicoesTime={posicoesTime} times={times.map(time=>time.nome)} aoJogadorCadastrado={jogador => aoNovoJogadorAdicionado(jogador)}/>
      
      {times.map(time => <Time 
       key={time.nome} 
       nome={time.nome}
       sobrenome={time.sobrenome}
       corPrimaria={time.corPrimaria} 
       corSecundaria={time.corSecundaria}
       posicao={time.posicoesTime}

       jogadores={jogadores.filter(jogador => jogador.time === time.nome)}
      />)}

      <Rodape />

    </div>
  );
}

export default App;
