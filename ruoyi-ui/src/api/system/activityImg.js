import request from '@/utils/request'

// 查询活动图片列表
export function listActivityImg(query) {
  return request({
    url: '/system/activityImg/list',
    method: 'get',
    params: query
  })
}

// 查询活动图片详细
export function getActivityImg(id) {
  return request({
    url: '/system/activityImg/' + id,
    method: 'get'
  })
}

// 新增活动图片
export function addActivityImg(data) {
  return request({
    url: '/system/activityImg',
    method: 'post',
    data: data
  })
}

// 修改活动图片
export function updateActivityImg(data) {
  return request({
    url: '/system/activityImg',
    method: 'put',
    data: data
  })
}

// 删除活动图片
export function delActivityImg(id) {
  return request({
    url: '/system/activityImg/' + id,
    method: 'delete'
  })
}

// 导出活动图片
export function exportActivityImg(query) {
  return request({
    url: '/system/activityImg/export',
    method: 'get',
    params: query
  })
}