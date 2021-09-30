import request from '@/utils/request'

// 查询活动时间（分场次）列表
export function listDate(query) {
  return request({
    url: '/system/date/list',
    method: 'get',
    params: query
  })
}

// 查询活动时间（分场次）详细
export function getDate(id) {
  return request({
    url: '/system/date/' + id,
    method: 'get'
  })
}

// 新增活动时间（分场次）
export function addDate(data) {
  return request({
    url: '/system/date',
    method: 'post',
    data: data
  })
}

// 修改活动时间（分场次）
export function updateDate(data) {
  return request({
    url: '/system/date',
    method: 'put',
    data: data
  })
}

// 删除活动时间（分场次）
export function delDate(id) {
  return request({
    url: '/system/date/' + id,
    method: 'delete'
  })
}

// 导出活动时间（分场次）
export function exportDate(query) {
  return request({
    url: '/system/date/export',
    method: 'get',
    params: query
  })
}