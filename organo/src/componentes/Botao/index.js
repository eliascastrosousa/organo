import './Botao.css'

const Botao = ({texto, disable}) => {
    if (disable) {
        return (<button className='botao' disabled> 
            {texto}
        </button>)
    }
    return (<button className='botao'> 
        {texto}
    </button>)
}

export default Botao