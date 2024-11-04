import { useState } from 'react';
import Banner from './componentes/Banner';
import Formulario from './componentes/Formulario';
import Time from './componentes/Time';
import Rodape from './componentes/Rodape';
import Navbar from './componentes/Navbar/Index';
import './App.css'
function App() {

  const times = [
    {
      nome: 'Club Athletico Paranaense',
      escudo: '',
      corPrimaria:'#C8102E',
      corSecundaria:'#2D2926',
      corTerciaria: '#FFFFFF'

    },
    {
      nome: 'Palmeiras',
      escudo: '',
      corPrimaria:'#008000',
      corSecundaria:'#9ef01a',
      corTerciaria: '#FFFFFF'
    },
    {
      nome: 'São Paulo',
      escudo: 'https://upload.wikimedia.org/wikipedia/commons/4/4b/S%C3%A3o_Paulo_Futebol_Clube.png',
      corPrimaria:'#FFFFFF',
      corSecundaria:'#DE0027',
      corTerciaria: '#000000'
    },{
      nome: 'Sport Club Internacional',
      escudo: '',
      corPrimaria:'#C8102E',
      corSecundaria:'#FFFFFF',
      corTerciaria: '#FFFFFF'
    }
    ,{
      nome: 'Esporte Clube Bahia',
      escudo: '',
      corPrimaria:'#3F5F9F',
      corSecundaria:'#C12723',
      corTerciaria: '#FFFFFF'
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
      <Banner/>
      <Formulario posicoesTime={posicoesTime} times={times.map(time=>time.nome)} aoJogadorCadastrado={jogador => aoNovoJogadorAdicionado(jogador)}/>
      
      {times.map(time => <Time 
       key={time.nome} 
       nome={time.nome}
       escudo={time.escudo}
       corPrimaria={time.corPrimaria} 
       corSecundaria={time.corSecundaria}
       corTerciaria={time.corTerciaria}
       posicao={time.posicoesTime}

       jogadores={jogadores.filter(jogador => jogador.time === time.nome)}
      />)}

      <Rodape />

    </div>
  );
}

export default App;
