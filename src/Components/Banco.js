import React, { useState } from "react";
import FormField from "./FormField";
import TransferenciaService from "../Service/TransferenciaService";

const transferenciaService = new TransferenciaService();

const Banco = () => {
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [operatorName, setOperatorName] = useState("");

  const search = async () => {
    try {
      let response;
      if (startDate && endDate !== "") {
        if (startDate > endDate) {
          alert("Data Inválida");
          setEndDate("");
          setStartDate("");
          return;
        }
        response = await transferenciaService.readByDate(
          startDate.replace(/ /g, ""),
          endDate.replace(/ /g, "")
        );
        alert("Atualizado");
      } else if (operatorName !== "") {
        response = await transferenciaService.findByOperator(operatorName);
        alert("Busca por operador");
      } else {
        response = await transferenciaService.findAllTransferencias();
      }
      createDataTableObject(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const createDataTableObject = (content) => {
    console.log("Content", content);
  };

  return (
    <>
      <section className="container border px-5 py-5 mb-5 my-5 font-weight-bold ">
        <div className=" ">
          <div className="row">
            <FormField
              id="startDate"
              label="Data Início"
              type="date"
              name="startDate"
              value={startDate}
              setValue={setStartDate}
            />
            <FormField
              id="endDate"
              label="Data Fim"
              type="date"
              name="endDate"
              value={endDate}
              setValue={setEndDate}
            />
            <FormField
              id="operatorName"
              label="Nome operador"
              type="text"
              name="operatorName"
              value={operatorName}
              setValue={setOperatorName}
            />
            <div className="col-1">
              <button className="btn btn-primary mt-5" onClick={search}>
                Pesquisar
              </button>
            </div>
          </div>
        </div>
      </section>
      <div className="container">
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Dados</th>
              <th scope="col">Valência</th>
              <th scope="col">Tipo</th>
              <th scope="col">Nome do Operador Transacionado</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>14/02/2019</td>
              <td>R$30895,46</td>
              <td>deposito</td>
              <td></td>
            </tr>
            <tr>
              <td>12/04/2019</td>
              <td>R$12,24</td>
              <td>transferencia entrada</td>
              <td>fulano</td>
            </tr>
            <tr>
              <td>11/06/2020</td>
              <td>R$-500,50</td>
              <td>transferencia saida</td>
              <td>Sicrano</td>
            </tr>
            <tr>
              <td>11/06/2020</td>
              <td>R$-1234,00</td>
              <td>saque</td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className="container mt-3">
        <ul className="pagination">
          <li className="page-item">
            <button className="page-link" disabled>
              &lt;&lt;
            </button>
          </li>
          <li className="page-item">
            <button className="page-link" disabled>
              &lt;
            </button>
          </li>
          <li className="page-item">
            <button className="page-link">1</button>
          </li>
          <li className="page-item">
            <button className="page-link">2</button>
          </li>
          <li className="page-item">
            <button className="page-link">3</button>
          </li>
          <li className="page-item">
            <button className="page-link">&gt;</button>
          </li>
          <li className="page-item">
            <button className="page-link">&gt;&gt;</button>
          </li>
        </ul>
      </div>
    </>
  );
};

export default Banco;

// Restante do código não foi alterado
