import request from '@/utils/request'

// 查询活动评论列表
export function listComment(query) {
  return request({
    url: '/system/comment/list',
    method: 'get',
    params: query
  })
}

// 查询活动评论详细
export function getComment(id) {
  return request({
    url: '/system/comment/' + id,
    method: 'get'
  })
}

// 新增活动评论
export function addComment(data) {
  return request({
    url: '/system/comment',
    method: 'post',
    data: data
  })
}

// 修改活动评论
export function updateComment(data) {
  return request({
    url: '/system/comment',
    method: 'put',
    data: data
  })
}

// 删除活动评论
export function delComment(id) {
  return request({
    url: '/system/comment/' + id,
    method: 'delete'
  })
}

// 导出活动评论
export function exportComment(query) {
  return request({
    url: '/system/comment/export',
    method: 'get',
    params: query
  })
}