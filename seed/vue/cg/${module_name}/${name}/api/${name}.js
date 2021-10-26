import {request} from './request.js'

const ${name}={
    list:(ctx)=>{
        return request.get("${name}/list",ctx)
    },
    detail:(ctx)=>{
      return request.get("${name}/detail",ctx)
    },
    del:(ctx)=>{
      return request.post("${name}/del",ctx)
    },
    create:(ctx)=>{
      return request.post("${name}/create",ctx)
    }
};

export {
  ${name}
}

