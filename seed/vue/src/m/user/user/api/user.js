import {request} from './request.js'

const user={
    list:(ctx)=>{
        return request.get("user/list",ctx)
    },
    detail:(ctx)=>{
      return request.get("user/detail",ctx)
    },
    del:(ctx)=>{
      return request.post("user/del",ctx)
    },
    create:(ctx)=>{
      return request.post("user/create",ctx)
    }
};

export {
  user
}

