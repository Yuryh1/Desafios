import ApiService from "./ApiService";

class TransferenciaService {
  constructor() {
    this.apiService = new ApiService('http://localhost:8082/transferencias');
  }

  async findAllTransferencias() {
    return await this.apiService.get("/");
  }

  async readByDate(startDate, endDate) {
    const url = `/byTempo?startDate=${startDate}&endDate=${endDate}`;
    return await this.apiService.get(url);
  }

  async findByOperator(operatorName) {
    const url = `/byNome?operatorName=${operatorName}`;
    return await this.apiService.get(url);
  }
}

export default TransferenciaService;
