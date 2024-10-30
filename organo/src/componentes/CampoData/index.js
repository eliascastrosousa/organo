import './CampoData.css'

const CampoData = (props) => {

    const aoDigitado = (evento) => {
        props.aoAlterado(evento.target.value)
    }

    return (
        <div className="campo-data">
            <label> {props.label} </label>
            <input type="date" value={props.valor} onChange={aoDigitado} required={props.obrigatorio} ></input>
        </div>
    )
}

export default CampoData