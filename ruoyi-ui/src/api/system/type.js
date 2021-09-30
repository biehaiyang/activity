import request from '@/utils/request'

// 查询所有分类列表
export function listType(query) {
  return request({
    url: '/system/type/list',
    method: 'get',
    params: query
  })
}

// 查询所有分类详细
export function getType(id) {
  return request({
    url: '/system/type/' + id,
    method: 'get'
  })
}

// 新增所有分类
export function addType(data) {
  return request({
    url: '/system/type',
    method: 'post',
    data: data
  })
}

// 修改所有分类
export function updateType(data) {
  return request({
    url: '/system/type',
    method: 'put',
    data: data
  })
}

// 删除所有分类
export function delType(id) {
  return request({
    url: '/system/type/' + id,
    method: 'delete'
  })
}

// 导出所有分类
export function exportType(query) {
  return request({
    url: '/system/type/export',
    method: 'get',
    params: query
  })
}