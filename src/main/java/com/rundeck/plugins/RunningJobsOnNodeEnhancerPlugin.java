package com.rundeck.plugins;

import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.descriptions.PluginDescription;
import com.dtolabs.rundeck.plugins.nodes.IModifiableNodeEntry;
import com.dtolabs.rundeck.plugins.nodes.NodeEnhancerPlugin;

@PluginDescription(
        title = "Running Jobs on Node Enhancer",
        description = "Updates 'running-jobs' attribute in nodes"
)
@Plugin(name = "RunningJobsOnNodeEnhancerPlugin", service = ServiceNameConstants.NodeEnhancer)
public class RunningJobsOnNodeEnhancerPlugin implements NodeEnhancerPlugin {
    @Override
    public void updateNode(String project, IModifiableNodeEntry node) {
        node.addAttribute("running-jobs", "" + RunningJobsOnNodeRepository.getInstance().jobCount(node));
    }
}
