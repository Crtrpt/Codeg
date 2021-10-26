import {request} from './request.js'

const auth={
    login:(ctx)=>{
        return request.post("auth/login",ctx)
    },
    signup:(ctx)=>{
      return request.post("auth/signup",ctx)
    },
    found:(ctx)=>{
        return request.post("auth/found",ctx)
    },
    getPhoneVerifCode:(ctx)=>{
      return request.post("auth/getPhoneVerifCode",ctx)
    },
};

export {
    auth
}

