import {request} from './request.js'

const ${name}={
    list:(ctx)=>{
        return request.get("${name}/list",ctx)
    },
};

export {
  ${name}
}

