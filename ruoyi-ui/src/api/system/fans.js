import request from '@/utils/request'

// 查询用户关注列表
export function listFans(query) {
  return request({
    url: '/system/fans/list',
    method: 'get',
    params: query
  })
}

// 查询用户关注详细
export function getFans(id) {
  return request({
    url: '/system/fans/' + id,
    method: 'get'
  })
}

// 新增用户关注
export function addFans(data) {
  return request({
    url: '/system/fans',
    method: 'post',
    data: data
  })
}

// 修改用户关注
export function updateFans(data) {
  return request({
    url: '/system/fans',
    method: 'put',
    data: data
  })
}

// 删除用户关注
export function delFans(id) {
  return request({
    url: '/system/fans/' + id,
    method: 'delete'
  })
}

// 导出用户关注
export function exportFans(query) {
  return request({
    url: '/system/fans/export',
    method: 'get',
    params: query
  })
}