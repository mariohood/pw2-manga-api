import axios from 'axios'

export const http = axios.create({
    baseURL: 'http://localhost:8081/bff/'
})

export const http_manga_api = axios.create({
    baseURL: 'http://localhost:8083/'
})