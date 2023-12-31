import request from '@/utils/request'

// 查询活动数据列表
export function listData(query) {
  return request({
    url: '/system/data/list',
    method: 'get',
    params: query
  })
}

// 查询活动数据详细
export function getData(id) {
  return request({
    url: '/system/data/' + id,
    method: 'get'
  })
}

// 新增活动数据
export function addData(data) {
  return request({
    url: '/system/data',
    method: 'post',
    data: data
  })
}

// 修改活动数据
export function updateData(data) {
  return request({
    url: '/system/data',
    method: 'put',
    data: data
  })
}

// 删除活动数据
export function delData(id) {
  return request({
    url: '/system/data/' + id,
    method: 'delete'
  })
}

// 导出活动数据
export function exportData(query) {
  return request({
    url: '/system/data/export',
    method: 'get',
    params: query
  })
}