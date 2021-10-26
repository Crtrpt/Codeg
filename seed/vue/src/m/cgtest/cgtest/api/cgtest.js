import {request} from './request.js'

const cgtest={
    list:(ctx)=>{
        return request.get("cgtest/list",ctx)
    },
};

export {
  cgtest
}

