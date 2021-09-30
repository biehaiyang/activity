import request from '@/utils/request'

// 查询动态列表
export function listDynamic(query) {
  return request({
    url: '/system/dynamic/list',
    method: 'get',
    params: query
  })
}

// 查询动态详细
export function getDynamic(id) {
  return request({
    url: '/system/dynamic/' + id,
    method: 'get'
  })
}

// 新增动态
export function addDynamic(data) {
  return request({
    url: '/system/dynamic',
    method: 'post',
    data: data
  })
}

// 修改动态
export function updateDynamic(data) {
  return request({
    url: '/system/dynamic',
    method: 'put',
    data: data
  })
}

// 删除动态
export function delDynamic(id) {
  return request({
    url: '/system/dynamic/' + id,
    method: 'delete'
  })
}

// 导出动态
export function exportDynamic(query) {
  return request({
    url: '/system/dynamic/export',
    method: 'get',
    params: query
  })
}