import request from '@/utils/request'

// 查询动态点赞列表
export function listStar(query) {
  return request({
    url: '/system/star/list',
    method: 'get',
    params: query
  })
}

// 查询动态点赞详细
export function getStar(id) {
  return request({
    url: '/system/star/' + id,
    method: 'get'
  })
}

// 新增动态点赞
export function addStar(data) {
  return request({
    url: '/system/star',
    method: 'post',
    data: data
  })
}

// 修改动态点赞
export function updateStar(data) {
  return request({
    url: '/system/star',
    method: 'put',
    data: data
  })
}

// 删除动态点赞
export function delStar(id) {
  return request({
    url: '/system/star/' + id,
    method: 'delete'
  })
}

// 导出动态点赞
export function exportStar(query) {
  return request({
    url: '/system/star/export',
    method: 'get',
    params: query
  })
}