package daily.frameworkapi.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerBeanMapperWrapper {

	private DozerBeanMapper dozerBeanMapper;
	
	public <T> T mapper(Object source, Class<T> destinationClass){
		return dozerBeanMapper.map(source, destinationClass);
	}
	
	public void mapper(Object source, Object destinationSource){
		dozerBeanMapper.map(source, destinationSource);
	}
	
	public <T> List<T> mapperList(List<?> sources , Class<T> destinationClass){
		List<T> targetList = new ArrayList<T>();
		for(Object source : sources){
			targetList.add(dozerBeanMapper.map(source, destinationClass));
		}
		return targetList;
	}
	
	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
	}
}
