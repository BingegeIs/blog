import Axios from 'axios'
import vue from '@/main'

const ENV = process.env.NODE_ENV

let host = process.env.VUE_APP_HOST

if (ENV !== 'development') {
  host = window.location.protocol + '//' + window.location.host
}


const axios = Axios.create({
  timeout: 10000,
  responseType: 'json',
  withCredentials: false
})

axios.interceptors.request.use(function (config) {
    // Do something before request is sent
    return config;
  }, function (error) {
    // Do something with request error
    return Promise.reject(error);
  });

axios.interceptors.response.use(
  data => {
    return data
  },
  error => {
    const { response: { status } = {} } = error
    if( status === 401) {
      vue.$router.push({ name: 'login' })
    }
    return Promise.reject(error)
  }
);

export { host, axios}
