import React, { useEffect, useState} from 'react';
import './App.css';
import api from './api';


 function App() {
  
  const [number, setNumber] = useState("101")
  const [resp, setResp] = useState("")
  const handleChange = e =>setNumber(e.target.value);
  const handleClick = () => {
    update()
  }
  function update(){
    api
    .get('/isduodigit/'+number)
      
    .then((response) => setResp(response.data))
    .catch((err) => {
      console.error("ops! ocorreu um erro" + err);
    });
  }
  function Rend(params) {
    if (resp?.msg === "ok"){
      return(
        <><p>Menor multiplo duodigito: {resp?.minDuodigit}</p><p>multiplicador: {resp?.multipler}</p></>
      )
    }else return(<p>mensagem: {resp?.msg}</p>)
  }
  return (
    <div className="App">
     
      <h1>Qual o menor multiplo duodigito?</h1>
      <p>Informe um numero maior que 100</p>
      
      <div className={'form'}>
        <input type='number' min='101' value={number} onChange={handleChange} className={'text-box'} />
        <input type='button' onClick={handleClick} value={'submit'} className={'button'} />
      </div>
    < Rend/>
    </div>
  );
}

export default App;