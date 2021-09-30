import request from '@/utils/request'

// 查询客服列表
export function listCenter(query) {
  return request({
    url: '/system/center/list',
    method: 'get',
    params: query
  })
}

// 查询客服详细
export function getCenter(id) {
  return request({
    url: '/system/center/' + id,
    method: 'get'
  })
}

// 新增客服
export function addCenter(data) {
  return request({
    url: '/system/center',
    method: 'post',
    data: data
  })
}

// 修改客服
export function updateCenter(data) {
  return request({
    url: '/system/center',
    method: 'put',
    data: data
  })
}

// 删除客服
export function delCenter(id) {
  return request({
    url: '/system/center/' + id,
    method: 'delete'
  })
}

// 导出客服
export function exportCenter(query) {
  return request({
    url: '/system/center/export',
    method: 'get',
    params: query
  })
}