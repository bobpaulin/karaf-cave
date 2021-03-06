/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.cave.deployer.command;

import org.apache.karaf.cave.deployer.api.Deployer;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "cave", name = "deployer-download", description = "Download an artifact to the local filesystem")
public class DownloadCommand implements Action {

    @Reference
    private Deployer deployer;

    @Argument(index = 0, name = "artifact", description = "The artifact URL", required = true, multiValued = false)
    String artifact;

    @Argument(index = 1, name = "directory", description = "The directory where to download the artifact", required = true, multiValued = false)
    String directory;

    @Override
    public Object execute() throws Exception {
        deployer.download(artifact, directory);
        return null;
    }

}
