import request from '@/utils/request'

// 查询充值列表
export function listRecharge(query) {
  return request({
    url: '/system/recharge/list',
    method: 'get',
    params: query
  })
}

// 查询充值详细
export function getRecharge(id) {
  return request({
    url: '/system/recharge/' + id,
    method: 'get'
  })
}

// 新增充值
export function addRecharge(data) {
  return request({
    url: '/system/recharge',
    method: 'post',
    data: data
  })
}

// 修改充值
export function updateRecharge(data) {
  return request({
    url: '/system/recharge',
    method: 'put',
    data: data
  })
}

// 删除充值
export function delRecharge(id) {
  return request({
    url: '/system/recharge/' + id,
    method: 'delete'
  })
}

// 导出充值
export function exportRecharge(query) {
  return request({
    url: '/system/recharge/export',
    method: 'get',
    params: query
  })
}