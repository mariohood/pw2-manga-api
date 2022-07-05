import { http, http_manga_api } from './config'
export default {

    

    list:() => {
        console.log("localStorage LIST: "+localStorage.getItem('token'));
        const USER_TOKEN = localStorage.getItem('token')
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN)
        return http.get('usuario/list', {headers: {Authorization: AUTH_STR}})
    },

    findbyID: (id) => {
        console.log("localStorage FIND BY ID: "+localStorage.getItem('token'));
        console.log(id)
        const USER_TOKEN = localStorage.getItem('token')
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN)
        var url = 'usuario/list/' + id;
        return http.get(url, {headers: {Authorization: AUTH_STR}})
    },

    login: (name, password) => {
        console.log("LOGINNNN: " + name + password);

        const params = new URLSearchParams();
        params.append('name', name);
        params.append('password', password);
        return http.post('usuario/login',params);
    },

    criar: (login, password, email) => {
        console.log("POST: " + login + password + email);
        console.log("localStorage TEST: "+localStorage.getItem('token'));
        const USER_TOKEN = localStorage.getItem('token')
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN)
        const params = new URLSearchParams();
        params.append('login', login);
        params.append('password', password);
        params.append('email', email);
        return http.post('usuario/create', params, {headers: {Authorization: AUTH_STR}});
    },

    update: (id, login, password, email) => {
        console.log("PUT: " + id + login + password + email);
        const USER_TOKEN = localStorage.getItem('token')
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN)
        var url = 'usuario/update/' + id;
        const params = new URLSearchParams();
        params.append('id', id);
        params.append('login', login);
        params.append('password', password);
        params.append('email', email);
        return http.put(url, params, {headers: {Authorization: AUTH_STR}})
    },

    deletar: (id) => {
        console.log("delete: " + id);
        const USER_TOKEN = localStorage.getItem('token')
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN)
        var url = 'usuario/delete/' + id;
        return http.delete(url,  {headers: {Authorization: AUTH_STR}})
    },

    pesquisarManga: (query) => {
        console.log("AXIOS: pesquisar por "+ query)
        var url = 'manga/search/' + query;
        return http_manga_api.get(url)
    },

    criarManga: (manga) => {
        console.log("AXIOS: ADD MANGA: "+ manga.mal_id+ manga.title + manga.image_url);
        const USER_TOKEN = localStorage.getItem('token');
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN);
        const IMAGE_URL = manga.image_url;
        console.log("IMAGE: " + IMAGE_URL)
        const params = new URLSearchParams();
        params.append('mal_id', manga.mal_id);
        params.append('image_url', IMAGE_URL);
        params.append('url', manga.url);
        params.append('chapters', manga.chapters);
        params.append('title', manga.title);
        console.log(params);
        return http.post('manga/create', params, {headers: {Authorization: AUTH_STR}});
    },

    criarAnuncio: (desc, id_manga) => {
        console.log("AXIOS: ADD ANUNCIO: "+ desc + id_manga);
        const USER_TOKEN = localStorage.getItem('token');
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN);
        const params = new URLSearchParams();
        params.append('manga_id', id_manga);
        params.append('user_id', localStorage.getItem('idLogado'));
        params.append('desc', desc);
        return http.post('anuncio/create', params, {headers: {Authorization: AUTH_STR}});
    },

    FindAnunciobyID: (id) => {
        console.log("localStorage FIND BY ID: "+localStorage.getItem('token'));
        console.log(id)
        const USER_TOKEN = localStorage.getItem('token')
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN)
        var url = 'anuncio/list/' + id;
        return http.get(url, {headers: {Authorization: AUTH_STR}})
    },

    postarMensagem:(anuncio_id, texto) => {
        console.log("AXIOS: ADD MENSAGEM: "+ anuncio_id + texto);
        const USER_TOKEN = localStorage.getItem('token');
        const AUTH_STR = 'Bearer '.concat(USER_TOKEN);
        const params = new URLSearchParams();
        params.append('anuncio_id', anuncio_id);
        params.append('user_id', localStorage.getItem('idLogado'));
        params.append('texto', texto);
        return http.post('mensagem/create', params, {headers: {Authorization: AUTH_STR}});
    }


}