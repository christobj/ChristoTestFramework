package org.ctf.listeners;

import org.ctf.constants.FrameworkConstants;
import org.ctf.utils.ExcelReaderUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String,String>> runManagerList = ExcelReaderUtil.getExcelDataList(FrameworkConstants.getRunmanger(),"run manager");
        result = getRunManagerConfig(runManagerList,methods);
        return result;
    }

    private List<IMethodInstance> getRunManagerConfig(List<Map<String,String>> runManagerList, List<IMethodInstance> methods) {
        List<IMethodInstance> runInstance = new ArrayList<>();
        for (int i=0 ; i < methods.size() ; i++) {
            for (int j=0 ; j< runManagerList.size() ; j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(runManagerList.get(j).get("Testcase Name"))) {
                    if (runManagerList.get(j).get("Enabled").equalsIgnoreCase("yes")) {
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(runManagerList.get(j).get("Invocation Count")));
                        methods.get(i).getMethod().setDescription(runManagerList.get(j).get("Description"));
                        runInstance.add(methods.get(i));
                    }
                }
            }
        }
        return runInstance;
    }
}
