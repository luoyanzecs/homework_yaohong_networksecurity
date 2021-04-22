import axios from "axios"

export function request(config){
  const instance = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 60000,
    // baseURL: '/api',
    // headers.['content-type'] = 'application/json',
  });
  return instance(config);
}
