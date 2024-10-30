import Jogador from '../Jogador/Index'
import './Time.css'

const Time = (props) => {


    return (
        (props.jogadores.length > 0) ?
        <section className='time' style={{backgroundColor: props.corPrimaria}}>
            <h3 style={{borderColor: props.corSecundaria }}> {props.nome}</h3>
            <div className='jogadores'>
            {props.jogadores.map(
                jogadores => 
                    <Jogador 
                        key={jogadores.nome}
                        nome={jogadores.nome} 
                        imagem={jogadores.imagem}
                        posicao={jogadores.posicao} 
                        dataNasc={jogadores.dataNasc}
                        corDeFundo={props.corSecundaria}
                    /> 
                )
            } 
            </div> 
        </section> : null
        
    ) 
}

export default Time