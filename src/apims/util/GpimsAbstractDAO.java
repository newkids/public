package apims.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * <pre>
 * @package name : gpims.Lms.pt.com
 * @file name    : GpimsAbstractDAO.java
 * @ EgovAbstractDAO 상속 받아서 편의성을 고려하여 만든 클래스
 * </pre>
 *
 *        수정일                  수정자                              수정내용
 * ---------------- --------- --------------------------
 *   2016. 1. 8.   bjeongh   최초생성
 *
 * @author       : bjeongh
 * @date         : 2016. 1. 8.
 * @Version      : 1.0
 * @Company      : s2info
 */
public class GpimsAbstractDAO extends EgovAbstractDAO{

	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * <pre>
	 *  EgovMap으로 리턴을 받을때 camel 형식으로 모든 데이터를 바꿔줌
	 * </pre>
	 *
	 * @Method Name : listForEgovMap
	 * @date        : 2016. 1. 8.
	 * @param queryId
	 * @param parameterObject
	 * @return
	 */
	public List<EgovMap> listForEgovMap(String queryId, Object parameterObject) {
		List<EgovMap> list = (List<EgovMap>) list(queryId, parameterObject);
		List<EgovMap> copyList = new ArrayList<EgovMap>();

		if (list != null && list.size() > 0){

			int size = list.size();

			for (int i = 0; i < size; i++){
				EgovMap copyEgovMap = new EgovMap();
				EgovMap egovMap = list.get(i);

				List keyList = egovMap.keyList();
				if (keyList != null && keyList.size() > 0){
					int keyListSize = keyList.size();
					for (int j = 0; j < keyListSize; j++){
						String key = (String) keyList.get(j);
						copyEgovMap.put(key, egovMap.get(key));
					}
				}

				copyList.add(copyEgovMap);
			}

			return copyList;
		}else{
			return list;
		}

	}

	/**
	 * <pre>
	 *  EgovMap으로 리턴을 받을때 camel 형식으로 모든 데이터를 바꿔줌
	 * </pre>
	 *
	 * @Method Name : selectForEgovMap
	 * @date        : 2016. 1. 8.
	 * @param queryId
	 * @param parameterObject
	 * @return
	 */
	public EgovMap selectForEgovMap(String queryId, Object parameterObject) {
		EgovMap egovMap = (EgovMap) getSqlMapClientTemplate().queryForObject(queryId, parameterObject);

		if (egovMap != null){
			EgovMap copyEgovMap = new EgovMap();
			List keyList = egovMap.keyList();
			if (keyList != null && keyList.size() > 0){
				int keyListSize = keyList.size();
				for (int j = 0; j < keyListSize; j++){
					String key = (String) keyList.get(j);
					copyEgovMap.put(key, egovMap.get(key));
				}
			}
			return copyEgovMap;
		}else{
			return egovMap;
		}
	}

	public List<?> listForVO(String queryId, Object parameterObject, Object returnObject){
		List<EgovMap> returnList = getSqlMapClientTemplate().queryForList(queryId, parameterObject);

		Object returnObjectValue = null;
		
		if (returnList != null && returnList.size() > 0){
			List list = new ArrayList();
			int size = returnList.size();
			for (int i = 0; i < size; i++){
				EgovMap map = returnList.get(i);
				try{
					returnObjectValue = returnObject.getClass().newInstance();
				}catch(InstantiationException e){
					e.printStackTrace();
				}catch(IllegalAccessException e){
					e.printStackTrace();
				}

				Object obj = this.convertMapToObject(map, returnObjectValue);
				list.add(obj);
			}

			return list;
		}
		else{
			return null;
		}
	}

	public Object selectForVO(String queryId, Object parameterObject, Object returnObject){
		EgovMap egovMap = (EgovMap) getSqlMapClientTemplate().queryForObject(queryId, parameterObject);

		if (egovMap != null){
			Object returnObjectValue;
			returnObjectValue = this.convertMapToObject1(egovMap, returnObject);
			return returnObjectValue;
		}else{
			return null;
		}
	}


	@Override
	public List<?> list(String queryId) {
		return getSqlMapClientTemplate().queryForList(queryId);
	}

	@Override
	public List<?> list(String queryId, Object parameterObject) {
		return getSqlMapClientTemplate().queryForList(queryId, parameterObject);
	}

	@Override
	public List<?> list(String queryId, int skipResults, int maxResults) {
		return getSqlMapClientTemplate().queryForList(queryId, skipResults,
				maxResults);
	}

	@Override
	public Object select(String queryId) {
		return getSqlMapClientTemplate().queryForObject(queryId);
	}

	@Override
	public Object select(String queryId, Object parameterObject) {
		return getSqlMapClientTemplate().queryForObject(queryId, parameterObject);
	}

	@Override
	public Object select(String queryId, Object parameterObject,
			Object resultObject) {
		return getSqlMapClientTemplate().queryForObject(queryId,
				parameterObject, resultObject);
	}

	@Override
	public Object insert(String queryId) {
		return getSqlMapClientTemplate().insert(queryId);
	}

	@Override
	public Object insert(String queryId, Object parameterObject) {
		return getSqlMapClientTemplate().insert(queryId, parameterObject);
	}

	@Override
	public int update(String queryId) {
		return getSqlMapClientTemplate().update(queryId);
	}

	@Override
	public int update(String queryId, Object parameterObject) {
		return getSqlMapClientTemplate().update(queryId, parameterObject);
	}

	@Override
	public void update(String queryId, Object parameterObject,
			int requiredRowsAffected) {
		getSqlMapClientTemplate().update(queryId, parameterObject,
				requiredRowsAffected);
	}

	@Override
	public int delete(String queryId) {
		return getSqlMapClientTemplate().delete(queryId);
	}

	@Override
	public int delete(String queryId, Object parameterObject) {
		return getSqlMapClientTemplate().delete(queryId, parameterObject);
	}

	@Override
	public void delete(String queryId, Object parameterObject,
			int requiredRowsAffected) {
		getSqlMapClientTemplate().delete(queryId, parameterObject,
				requiredRowsAffected);
	}




	/**
	 * <pre>
	 * 
	 * </pre>
	 *
	 * @Method Name : convertMapToObject
	 * @date        : 2016. 1. 15.
	 * @param map
	 * @param objClass
	 * @return
	 */
	private Object convertMapToObject(EgovMap map, Object objClass){
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		List<String> keyList = map.keyList();
		if (keyList != null && keyList.size() > 0){
			int keyListSize = keyList.size();
			for (int i = 0; i < keyListSize; i++){
				keyAttribute = keyList.get(i);
				methodString = setMethodString+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);
				try {
					Method[] methods = objClass.getClass().getDeclaredMethods();
					for(int j=0;j<=methods.length-1;j++){
						if(methodString.equalsIgnoreCase(methods[j].getName())){
							methods[j].invoke(objClass, String.valueOf(map.get(keyAttribute)));
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return objClass;
	}

	private Object convertMapToObject1(EgovMap map, Object objClass){
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		List<String> keyList = map.keyList();
		if (keyList != null && keyList.size() > 0){
			int keyListSize = keyList.size();
			for (int i = 0; i < keyListSize; i++){
				keyAttribute = keyList.get(i);
				methodString = setMethodString+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);
				try {
					Method[] methods = objClass.getClass().getMethods();
					for(int j=0;j<=methods.length-1;j++){
						if(methodString.equalsIgnoreCase(methods[j].getName())){
							methods[j].invoke(objClass, String.valueOf(map.get(keyAttribute)));
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return objClass;
	}
}
