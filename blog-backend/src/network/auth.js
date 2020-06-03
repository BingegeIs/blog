import { axios, host } from './base'

const auth = {
    login(params) {
        return axios.post(`${host}/api/auth/login`, params).then(({ data }) => data)
    }
}

export default auth
