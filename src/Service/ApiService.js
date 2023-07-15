import axios from "axios";

class ApiService {
  constructor(apiurl) {
    this.httpClient = axios.create({
      baseURL: apiurl
    });
  }
  
  async get(url) {
    const requestUrl = `${url}`;

    try {
      const response = await this.httpClient.get(requestUrl);
      return response.data;
    } catch (error) {
      throw new Error(`Error calling ${requestUrl}: ${error.message}`);
    }
  }
}

export default ApiService;
