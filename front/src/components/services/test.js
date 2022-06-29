import { http } from './config'

export default {

    list:() => {
        return http.get('usuario/list')
    },

    login: () => {
        return http.post('usuario/login', {
         data: {id: '7', name: 'ale', password: '123'}
        })
    },

    criar: (login, password, email) => {
        console.log("POST: " + login + password + email);
        const params = new URLSearchParams();
        params.append('login', login);
        params.append('password', password);
        params.append('email', email);
        return http.post('usuario/create', params);
    },

    update: (id, login, password, email) => {
        console.log("PUT: " + id + login + password + email);
        var url = 'usuario/update/' + id;
        const params = new URLSearchParams();
        params.append('id', id);
        params.append('login', login);
        params.append('password', password);
        params.append('email', email);
        return http.put(url, params)
    },

    deletar: (id) => {
        console.log("delete: " + id);
        var url = 'usuario/delete/' + id;
        return http.delete(url)
    }

}