import axios from 'axios'
import store from '../store/store'
import * as types from '../store/type'
import router from '../router'

// axios默认配置
axios.defaults.timeout = 30000;
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
axios.defaults.baseURL = 'http://127.0.0.1:8083';
axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'

//整理数据
axios.defaults.transformRequest = function (data) {
//data = Qs.stringify(data);
  data = JSON.stringify(data);
  return data;
};

/// http request 拦截器
axios.interceptors.request.use(
  config => {
    if (store.state.token) {
      config.headers.Authorization = `Bearer ${store.state.token}`;
    }
    return config;
  },
  err => {
    return Promise.reject(err);
  });

// http response 拦截器
axios.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          // 401 清除token信息并跳转到登录页面
          store.commit(types.LOGOUT);
          this.$router.replace({
            name: 'login',
            param: {redirect: this.$router.currentRoute.fullPath}
          })
      }
    }
    // console.log(JSON.stringify(error));//console : Error: Request failed with status code 402
    return Promise.reject(error.response.data)
  });


/**
 * fetch=》get请求方法
 * @param url
 * @param params
 * @returns {Promise<any>}
 */
export function fetch(url, params = {}) {
  return new Promise((resolve, reject) => {
    axios.get(url, {
      params: params
    })
      .then(response => {
        resolve(response.data);
      })
      .catch(err => {
        reject(err)
      })
  })
}

/**
 * Post 请求方法
 * @param url
 * @param data
 * @returns {Promise<any>}
 */
export function post(url,data={}){
  return new Promise((resolve,reject)=>{
    axios.post(url,data)
      .then(response=>{
        resolve(response.data);
      },err=>{
        reject(err);
      })
  })
}

/**
 * patch 方法封装
 * @param url
 * @param data
 * @returns {Promise<any>}
 */
export function patch(url,data={}){
  return new Promise((resolve,reject)=>{
    axios.patch(url,data)
      .then(response=>{
        resolve(response.data);
      },err=>{
        reject(err);
      })
  })
}

/**
 * put 方法封装
 * @param url
 * @param data
 * @returns {Promise<any>}
 */
export function put(url,data={}){
  return new Promise((resolve,reject)=>{
    axios.put(url,data)
      .then(response=>{
        resolve(response.data);
      },err=>{
        reject(err);
      })
  })
}

/**
 * delete 方法封装
 * @param url
 * @param params
 * @returns {Promise<any>}
 */
export function del(url, params = {}) {
  return new Promise((resolve, reject) => {
    axios.delete(url, {
      params: params
    })
      .then(response => {
        resolve(response.data);
      })
      .catch(err => {
        reject(err)
      })
  })
}

export default axios


