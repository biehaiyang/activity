import request from '@/utils/request'

// 查询活动规格列表
export function listSpec(query) {
  return request({
    url: '/system/spec/list',
    method: 'get',
    params: query
  })
}

// 查询活动规格详细
export function getSpec(id) {
  return request({
    url: '/system/spec/' + id,
    method: 'get'
  })
}

// 新增活动规格
export function addSpec(data) {
  return request({
    url: '/system/spec',
    method: 'post',
    data: data
  })
}

// 修改活动规格
export function updateSpec(data) {
  return request({
    url: '/system/spec',
    method: 'put',
    data: data
  })
}

// 删除活动规格
export function delSpec(id) {
  return request({
    url: '/system/spec/' + id,
    method: 'delete'
  })
}

// 导出活动规格
export function exportSpec(query) {
  return request({
    url: '/system/spec/export',
    method: 'get',
    params: query
  })
}