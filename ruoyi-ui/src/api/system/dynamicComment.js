import request from '@/utils/request'

// 查询动态评论列表
export function listDynamicComment(query) {
  return request({
    url: '/system/dynamicComment/list',
    method: 'get',
    params: query
  })
}

// 查询动态评论详细
export function getDynamicComment(id) {
  return request({
    url: '/system/dynamicComment/' + id,
    method: 'get'
  })
}

// 新增动态评论
export function addDynamicComment(data) {
  return request({
    url: '/system/dynamicComment',
    method: 'post',
    data: data
  })
}

// 修改动态评论
export function updateDynamicComment(data) {
  return request({
    url: '/system/dynamicComment',
    method: 'put',
    data: data
  })
}

// 删除动态评论
export function delDynamicComment(id) {
  return request({
    url: '/system/dynamicComment/' + id,
    method: 'delete'
  })
}

// 导出动态评论
export function exportDynamicComment(query) {
  return request({
    url: '/system/dynamicComment/export',
    method: 'get',
    params: query
  })
}
