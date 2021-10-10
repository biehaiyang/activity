import request from '@/utils/request'

// 查询账户详情列表
export function listAccount(query) {
  return request({
    url: '/system/account/list',
    method: 'get',
    params: query
  })
}

// 查询账户详情详细
export function getAccount(id) {
  return request({
    url: '/system/account/' + id,
    method: 'get'
  })
}

// 新增账户详情
export function addAccount(data) {
  return request({
    url: '/system/account',
    method: 'post',
    data: data
  })
}

// 修改账户详情
export function updateAccount(data) {
  return request({
    url: '/system/account',
    method: 'put',
    data: data
  })
}

// 删除账户详情
export function delAccount(id) {
  return request({
    url: '/system/account/' + id,
    method: 'delete'
  })
}

// 导出账户详情
export function exportAccount(query) {
  return request({
    url: '/system/account/export',
    method: 'get',
    params: query
  })
}