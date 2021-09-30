import request from '@/utils/request'

// 查询用户审核列表
export function listAudit(query) {
  return request({
    url: '/system/audit/list',
    method: 'get',
    params: query
  })
}

// 查询用户审核详细
export function getAudit(id) {
  return request({
    url: '/system/audit/' + id,
    method: 'get'
  })
}

// 新增用户审核
export function addAudit(data) {
  return request({
    url: '/system/audit',
    method: 'post',
    data: data
  })
}

// 修改用户审核
export function updateAudit(data) {
  return request({
    url: '/system/audit',
    method: 'put',
    data: data
  })
}

// 删除用户审核
export function delAudit(id) {
  return request({
    url: '/system/audit/' + id,
    method: 'delete'
  })
}

// 导出用户审核
export function exportAudit(query) {
  return request({
    url: '/system/audit/export',
    method: 'get',
    params: query
  })
}