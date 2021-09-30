import request from '@/utils/request'

// 查询用户浏览历史列表
export function listHistory(query) {
  return request({
    url: '/system/history/list',
    method: 'get',
    params: query
  })
}

// 查询用户浏览历史详细
export function getHistory(id) {
  return request({
    url: '/system/history/' + id,
    method: 'get'
  })
}

// 新增用户浏览历史
export function addHistory(data) {
  return request({
    url: '/system/history',
    method: 'post',
    data: data
  })
}

// 修改用户浏览历史
export function updateHistory(data) {
  return request({
    url: '/system/history',
    method: 'put',
    data: data
  })
}

// 删除用户浏览历史
export function delHistory(id) {
  return request({
    url: '/system/history/' + id,
    method: 'delete'
  })
}

// 导出用户浏览历史
export function exportHistory(query) {
  return request({
    url: '/system/history/export',
    method: 'get',
    params: query
  })
}