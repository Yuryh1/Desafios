import React from 'react'
import DataTable from 'react-data-table-component'
 
const MyDataTable = ({ columns, data }) => {
  return (
    <div className="container border px-5 py-5 mb-5 my-5 font-weight-bold">
      <div className="row">
        <p className="col-6">Saldo total: R$ 50</p>
        <p className="col-6">Saldo no período: R$ 50</p>
      </div>

      <DataTable columns={columns} data={data} />
    </div>
  )
}

export default MyDataTable
