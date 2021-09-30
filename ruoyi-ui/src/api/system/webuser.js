import request from '@/utils/request'

// 查询用户列表
export function listWebuser(query) {
  return request({
    url: '/system/webuser/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getWebuser(id) {
  return request({
    url: '/system/webuser/' + id,
    method: 'get'
  })
}

// 新增用户
export function addWebuser(data) {
  return request({
    url: '/system/webuser',
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateWebuser(data) {
  return request({
    url: '/system/webuser',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delWebuser(id) {
  return request({
    url: '/system/webuser/' + id,
    method: 'delete'
  })
}

// 导出用户
export function exportWebuser(query) {
  return request({
    url: '/system/webuser/export',
    method: 'get',
    params: query
  })
}