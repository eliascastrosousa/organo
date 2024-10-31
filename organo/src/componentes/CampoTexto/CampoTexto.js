import "./CampoTexto.css";

const CampoTexto = (props) => {
  const placeholderModificado = `${props.placeholder}`;

  const aoDigitado = (evento) => {
    props.aoAlterado(evento.target.value);
  };

  return (
    <>
      <label
        htmlFor="first-name"
        className="block text-sm/6 font-medium text-gray-900"
      >
        {props.label}
      </label>
      <div className="mt-2">
        <input
          type="text"
          className="pl-2 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm/6"
          value={props.valor} 
          onChange={aoDigitado} 
          required={props.obrigatorio} 
          placeholder={placeholderModificado}
        />
      </div>
    </>
  );
};

export default CampoTexto;
