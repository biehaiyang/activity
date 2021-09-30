import request from '@/utils/request'

// 查询广告图片列表
export function listBanner(query) {
  return request({
    url: '/system/banner/list',
    method: 'get',
    params: query
  })
}

// 查询广告图片详细
export function getBanner(id) {
  return request({
    url: '/system/banner/' + id,
    method: 'get'
  })
}

// 新增广告图片
export function addBanner(data) {
  return request({
    url: '/system/banner',
    method: 'post',
    data: data
  })
}

// 修改广告图片
export function updateBanner(data) {
  return request({
    url: '/system/banner',
    method: 'put',
    data: data
  })
}

// 删除广告图片
export function delBanner(id) {
  return request({
    url: '/system/banner/' + id,
    method: 'delete'
  })
}

// 导出广告图片
export function exportBanner(query) {
  return request({
    url: '/system/banner/export',
    method: 'get',
    params: query
  })
}