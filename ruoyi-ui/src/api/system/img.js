import request from '@/utils/request'

// 查询动态图片列表
export function listImg(query) {
  return request({
    url: '/system/img/list',
    method: 'get',
    params: query
  })
}

// 查询动态图片详细
export function getImg(id) {
  return request({
    url: '/system/img/' + id,
    method: 'get'
  })
}

// 新增动态图片
export function addImg(data) {
  return request({
    url: '/system/img',
    method: 'post',
    data: data
  })
}

// 修改动态图片
export function updateImg(data) {
  return request({
    url: '/system/img',
    method: 'put',
    data: data
  })
}

// 删除动态图片
export function delImg(id) {
  return request({
    url: '/system/img/' + id,
    method: 'delete'
  })
}

// 导出动态图片
export function exportImg(query) {
  return request({
    url: '/system/img/export',
    method: 'get',
    params: query
  })
}