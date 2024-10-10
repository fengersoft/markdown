import request from '@/utils/request.js'
export const add=(params)=>{
    return request({
        url:'/api/markdown/add',
        method:'post',
        data:params
    })
}
export const edit=(params)=>{
    return request({
        url:'/api/markdown/edit',
        method:'post',
        data:params
    })
}
export const showTitles=(params)=>{
    return request({
        url:'/api/markdown/showTitles',
        method:'post',
        data:params
    })
}
export const showInfo=(id)=>{
    return request({
        url:`/api/markdown/showInfo/${id}`,
        method:'post',
        data:null
    })
}
export const deleteInfo=(id)=>{
    return request({
        url:`/api/markdown/del/${id}`,
        method:'post',
        data:null
    })
}
export const search=(params)=>{
    return request({
        url:'/api/markdown/search',
        method:'post',
        data:params
    })
}