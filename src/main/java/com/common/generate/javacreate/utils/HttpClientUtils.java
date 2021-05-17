/**   
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.common.generate.javacreate.utils;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Map;


/**
 * @Title: HttpClientUtils.java
 * @Package com.yijiupi.himalaya.api.supplychain.util
 * @Description:
 * @author wangran
 * @date 2017年10月23日 下午5:29:10
 * @version
 */
public class HttpClientUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

	private HttpClientUtils() {}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 50; i++) {
//			String s = doPost("https://www.baidu.com", "");
//			System.out.println(s);

			String s = doPostWithToken("3a3075cb-808a-4af9-b49f-0e345c5e67e8", "http://wms.release.yijiupidev.com/supplyChain/base/test2?warehouseId=11", "{}");
			System.out.println(i+":"+s);
			Thread.sleep(3000L);
		}
	}
	
	/**
	 * post请求
	 * 
	 * @param url
	 * @param body
	 * @return
	 */
	public static String doPost(String url, String body) {
		try {
			LOGGER.info("POST请求,url:" + url + "参数：" + body);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Accept", "application/json");
			headers.add("Accpet-Encoding", "gzip");
			headers.add("Content-Encoding", "UTF-8");
			headers.add("Content-Type", "application/json; charset=UTF-8");
			HttpEntity<String> formEntity = new HttpEntity<>(body, headers);
			return RestClient.getClient().postForObject(url, formEntity, String.class);
		} catch (Exception e) {
			LOGGER.error("POST请求出错,url:" + url + "参数：" + body, e);
		}
		return null;
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param formParams
	 * @return
	 */
	// public static String doPost(String url, Map<String, String> formParams) {
	// try {
	// MultiValueMap<String, String> requestEntity = new
	// LinkedMultiValueMap<>();
	// formParams.keySet().stream().forEach(key -> requestEntity.add(key,
	// MapUtils.getString(formParams, key, "")));
	// return RestClient.getClient().postForObject(url, requestEntity,
	// String.class);
	// } catch (Exception e) {
	// LOGGER.error("POST请求出错：{}", url, e);
	// }
	// return null;
	// }

	/**
	 * post请求
	 * 
	 * @param url
	 * @return
	 */
	public static String doPost(String url) {
		try {
			return RestClient.getClient().postForObject(url, HttpEntity.EMPTY, String.class);
		} catch (Exception e) {
			LOGGER.error("POST请求出错：{}", url, e);
		}

		return null;
	}

	/**
	 * get请求
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		LOGGER.info("GET请求,url:" + url);

		try {
			return RestClient.getClient().getForObject(url, String.class);
		} catch (Exception e) {
			LOGGER.error("GET请求出错,url:" + url, e);
		}

		return null;
	}

	public static String doGetMap(String url, Map<String, ?> params) {
		try {
			String result = RestClient.getClient().getForObject(url, String.class, params);
			return result;
		} catch (Exception e) {
			LOGGER.error("GET请求出错,url:" + url + ",参数:" + params, e);
		}

		return null;
	}


	public static String doGetWithToken(String token, String url){
		CloseableHttpResponse response = null;
		CloseableHttpClient client = HttpClients.createDefault();
		String responseContent = null; // 响应内容
		try {
			HttpGet get = new HttpGet(url);
			get.setHeader("Content-Type", "application/json;charset=utf8");
			get.addHeader("token", token);
			response = client.execute(get);
			System.out.println(JSON.toJSONString(response));
			if (response.getStatusLine().getStatusCode() == 200) {
				org.apache.http.HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, "UTF-8");
				LOGGER.info("responseContent:" + responseContent);

			}
			if (response != null) {
				response.close();
			}
			if (client != null) {
				client.close();
			}
		}catch (Exception e){
			throw new BusinessException("请求失败:" + e.getMessage());
		}finally {
			// 释放资源
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				LOGGER.error("关闭client出错", e);
			}

			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				LOGGER.error("关闭response出错", e);
			}
		}
		return responseContent;
	}


    public static String doPostWithToken(String token, String url,String body) {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();
        String responseContent = null; // 响应内容
        try {

            HttpPost post = new HttpPost(url);
            System.out.println("要发送的数据：" + body);
            StringEntity myEntity = new StringEntity(body, ContentType.APPLICATION_JSON); // 构造请求数据
            post.setHeader("Content-Type", "application/json;charset=utf8");
            post.addHeader("token",token);
            post.setEntity(myEntity); // 设置请求体
            response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                org.apache.http.HttpEntity entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
                LOGGER.info("responseContent:" + responseContent);

            }
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        } catch (Exception e) {
            throw new BusinessException("erp请求失败:" + e.getMessage());
        } finally {
            // 释放资源
            try {
                if (client != null) {
					client.close();	
                }
			} catch (IOException e) {
				LOGGER.error("关闭client出错", e);
			}

            try {
                if (response != null) {
					response.close();
                }
			} catch (IOException e) {
				LOGGER.error("关闭response出错", e);
			}
        }
        return responseContent;
    }



	public static String doPostWithCookie(String cookie, String url,String body) {
		CloseableHttpResponse response = null;
		CloseableHttpClient client = HttpClients.createDefault();
		String responseContent = null; // 响应内容
		try {

			HttpPost post = new HttpPost(url);
			System.out.println("要发送的数据：" + body);
			StringEntity myEntity = new StringEntity(body, ContentType.APPLICATION_JSON); // 构造请求数据
			post.setHeader("Content-Type", "application/json;charset=utf8");
			post.addHeader("Cookie",cookie);
			post.setEntity(myEntity); // 设置请求体
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() == 200) {
				org.apache.http.HttpEntity entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, "UTF-8");
				LOGGER.info("responseContent:" + responseContent);

			}
			if (response != null) {
				response.close();
			}
			if (client != null) {
				client.close();
			}
		} catch (Exception e) {
			throw new BusinessException("erp请求失败:" + e.getMessage());
		} finally {
			// 释放资源
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				LOGGER.error("关闭client出错", e);
			}

			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				LOGGER.error("关闭response出错", e);
			}
		}
		return responseContent;
	}
	
	public static String doPost(String url, String body, HttpHeaders headers) {
		try {
			headers.add("Accept", "application/json");
			headers.add("Accpet-Encoding", "gzip");
			headers.add("Content-Encoding", "UTF-8");
			headers.add("Content-Type", "application/json; charset=UTF-8");
			HttpEntity<String> formEntity = new HttpEntity<>(body, headers);
			return RestClient.getClient().postForObject(url, formEntity, String.class);
		} catch (Exception e) {
			LOGGER.error("POST请求出错,url:" + url + "参数：" + body, e);
		}

		return null;
	}

}
